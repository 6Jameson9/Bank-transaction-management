// 3. Creating classes for observers (clients and administrators).
class Client implements Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        // Logic for updating the client when receiving a notification
    }
}
