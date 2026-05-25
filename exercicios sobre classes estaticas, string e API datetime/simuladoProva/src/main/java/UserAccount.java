
public class UserAccount {
    private String email, userName;
    private final Post[] timeline = new Post[10];
    private final Post[] userPosts =  new Post[100];
    private int userPostQtd = 0, followersQtd = 0, timelineQtd = 0;
    private final UserAccount[] followers =  new UserAccount[100];

    public UserAccount(String email, String userName){
        if(!email.isBlank() && !userName.isBlank()){
            this.email = email;
            this.userName = userName;
        }
    }
    //optei pelo construtor completo pois não tem como criar conta sem email e nome, pode mudar depois mas criar não é possivel

    public void publish(String quote){
        Post userPost = new Post();

        userPost.Post(this, quote);
        userPosts[userPostQtd++] = userPost;
        for(int i = 0; i<followersQtd; i++){
            followers[i].updateTimeline(userPost);
        }
    }

    public void updateTimeline(Post newPost){
        if(timelineQtd <10){
            timeline[timelineQtd++] = newPost;
        }
        else {
            int oldestPost = 0;

            for(int i = 1; i<timelineQtd; i++){
                if(timeline[oldestPost].getDate().isAfter(timeline[i].getDate())){
                    oldestPost = i;
                }
            }
            timeline[oldestPost] = newPost;
        }
    }

    public Boolean delete(int indexPost){
        if(indexPost < userPostQtd){
            for(int i = indexPost; i<userPostQtd-1; i++){
                userPosts[i] = userPosts[i+1];
            }
            userPostQtd--;
            return true;
        }
        return false;
    }

    public String showTimeline() {
        if (timelineQtd > 0) {
            StringBuilder timelineString = new StringBuilder();
            for (int i = 0; i < timelineQtd; i++) {
                timelineString.append(timeline[i].Show());
                timelineString.append("\n");
            }
            return timelineString.toString();
        }
        return "timeline vazia";
    }

    public String showMyPost() {
        if (userPostQtd > 0) {
            StringBuilder postsString = new StringBuilder();
            for (int i = 0; i < userPostQtd;i++){
                postsString.append(userPosts[i].Show());
                postsString.append("\n");
            }
            return postsString.toString();
        }
        return "nenhum post feito";
    }

    public String showMyFriends(){
        // interpretei que poderia ser os objetos que se seguem mutuamente, mas como não tem nada especificado deixei apenas os seguidores do objeto
        if(followersQtd>0){
            StringBuilder friends = new StringBuilder();
            for(int i =0; i<followersQtd;i++){
                friends.append(followers[i].getUserName());
                friends.append("\n");
            }
            return friends.toString();
        }
        return "voce ainda nao tem amigos";
    }

    public void clapPost(int indexPost){
        if(timelineQtd>indexPost){
            timeline[indexPost].clap();
        }
    }

    public void booPost(int indexPost){
        if(timelineQtd>indexPost){
            timeline[indexPost].boo();
        }
    }

    void acceptFollower(UserAccount newFollower){
        if(newFollower!=null) {
            followers[followersQtd++] = newFollower;
        }

    }

    void blockFollower(UserAccount follower){
        if(follower != null){
            for(int i = 0; i<followersQtd; i++){
                if(follower == followers[i]){
                    for(int j = i; j<followersQtd-1;j++){
                        followers[j] = followers[j+1];
                    }
                    followersQtd--;
                    break;
                }
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String newUserName){
        if(!newUserName.isBlank()){
            userName = newUserName;
        }
    }

    public void setEmail(String email) {
        if(!email.isBlank()) {
            this.email = email;
        }
    }

    public String getEmail(){
        return email;
    }

}
