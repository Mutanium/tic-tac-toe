package nl.phoyd;

public class Field {
    //velden
    private String token;
    private boolean isOccupied;

    //constructors
    public Field(String token) {
        this.token = token;
        isOccupied = false;
    }

    //methodes
    public void setToken(String token) {
        //of: if(!isOccupied) is het zelfde als: if(isOccupied == false) maar dan korter
        if(isOccupied == false) {
            this.token = token;
        }
        isOccupied = true;
    }

    public String getToken() {
        return token;
    }
}
