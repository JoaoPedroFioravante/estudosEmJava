package model;

public record PlayerDTO(int id,
        String position,
        String name,
        int number,
        boolean isFielded,
        String team) {
    public static PlayerDTO toDTO(Player player){
        return new PlayerDTO(player.getId(), player.getPosition(), player.getName(), player.getNumber(), player.isFielded(), player.getTeam().getName());
    }
}
