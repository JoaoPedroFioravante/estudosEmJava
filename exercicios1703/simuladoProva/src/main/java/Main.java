public class Main {
    public static void main(){
        UserAccount user1 = new UserAccount("teste@gmail.com", "teste1");
        UserAccount user2 = new UserAccount("teste@gmail.com", "teste2");
        UserAccount user3 = new UserAccount("teste@gmail.com", "teste3");
        UserAccount user4 = new UserAccount("teste@gmail.com", "teste4");

        user1.acceptFollower(user2);
        user1.acceptFollower(user3);
        user1.acceptFollower(user4);
        System.out.println(user1.showMyFriends());
        user1.publish("programação orientado a objeto");
        user1.publish("teste de poo");

        user2.clapPost(0);
        user2.booPost(1);
        user3.clapPost(0);
        user3.clapPost(1);

        user3.acceptFollower(user4);
        user3.acceptFollower(user1);
        user3.publish("teste amigos");

        user1.blockFollower(user2);
        user1.publish("teste de blocking");

        user3.clapPost(2);

        System.out.println(user2.showTimeline());
        System.out.println("================");
        System.out.println(user3.showTimeline());
        System.out.println("===============");

        user1.clapPost(0);
        user1.clapPost(4);
        System.out.println(user1.showTimeline());

        System.out.println("===================== show e delete post");
        System.out.println(user1.showMyPost());
        System.out.println("===================");
        if(user1.delete(1)){
            System.out.println("post deletado com sucesso 1 ");
        }
        if(user1.delete(4)){
            System.out.println("post deletado com sucesso 2");
        }

        System.out.println(user1.showMyPost());
        System.out.println("===================");
        System.out.println(user4.showTimeline());
    }
}
