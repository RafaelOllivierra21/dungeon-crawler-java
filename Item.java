public abstract class Item {
    private String name;
    private String description;

    // constructor
    public Item (String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString(){
        return this.getName() + ": " + this.getDescription();
    }
}
