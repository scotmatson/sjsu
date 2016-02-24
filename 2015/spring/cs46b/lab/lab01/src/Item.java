public class Item implements Comparable
{
    private String name;
    private String key;
    private String value;


    public Item (String name, String key, String value) {
        this.name = name;
        this.key = key;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Item other = (Item) o;
        if(name.compareTo(other.name) != 0) {
            return name.compareTo(other.name);
        }
        else if (key.compareTo(other.key) == 0) {
            return value.compareTo(other.value);
        }

        return 0;
    }

    @Override
    public String toString() {
        return "*** Item*** \nName: " + name + "\nKey:" + key + "\nValue: " + value;
    }

    @Override
    public boolean equals(Object obj) {
        Item other = (Item) obj;
        if (name.equals(other.name)) {
            if (key.equals(other.key)) {
                if (value.equals(other.value)) {
                    return true;
                }
            }
        }
        return false;
    }
}

