import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private double userLimit;
    private List<Product> listaCompras;

    public User(String userName, double userLimit){
        this.userName = userName;
        this.userLimit = userLimit;
        this.listaCompras = new ArrayList<>();
    };

    public boolean userPurchase(Product produto){
        if (this.userLimit >= produto.getProductPrice()){
           this.userLimit -= produto.getProductPrice();
           this.listaCompras.add(produto);
           return true;
        }
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public double getUserLimit() {
        return userLimit;
    }

    public List<Product> getListaCompras() {
        return listaCompras;
    }
}
