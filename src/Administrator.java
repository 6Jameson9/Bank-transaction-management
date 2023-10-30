// 3
class Administrator implements Observer {
    private String name;

    public Administrator(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        // Logic for updating the admin when receiving a notification
    }
}
