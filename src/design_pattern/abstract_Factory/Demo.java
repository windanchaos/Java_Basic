package design_pattern.abstract_Factory;

public class Demo {
    public static void main(String[] args) {
        Client client = new Client(new Factory1());
        client.productDo();
    }

}

class Client{
    public AbstractFactory abstractFactory;
    public Product product;
    public Client(AbstractFactory abstractFactory){
        this.product = abstractFactory.create();
    }
    public void productDo(){
        this.product.action();
    }
}

abstract class AbstractFactory {
    abstract Product create();
}

class Factory1 extends AbstractFactory{
    public Product create() {
        return new Product12();
    }
}
class Factory2 extends AbstractFactory{
    public Product create() {
        return new Product22();
    }
}

abstract class Product{
    abstract void action();
}

abstract class AbstractProduct extends Product {

}


class Product12 extends AbstractProduct{

    @Override
    void action() {
        System.out.println("Product12");
    }
}

class Product22 extends AbstractProduct{
    @Override
    void action() {
        System.out.println("Product22");
    }
}