package Books_task;

public class Customer {
    private int id;
    String last_name;
    private String address;
    private int card_number;
    private String schet_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public String getSchet_number() {
        return schet_number;
    }

    public void setSchet_number(String schet_number) {
        this.schet_number = schet_number;
    }


    public Customer(int id, String last_name, String address, int card_number, String schet_number) {

        this.id = id;
        this.last_name = last_name;
        this.address = address;
        this.card_number = card_number;
        this.schet_number = schet_number;
    }

    @Override
    public String toString() {
        return "Customer" + id + "{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", card_number=" + card_number +
                ", schet_number=" + schet_number +
                '}';
    }
}
