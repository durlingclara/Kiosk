/*******************************************************************************
 * Reward.java
 * Clara Durling
 * 
 * This is a class for a reward earned by a member.
 ******************************************************************************/
package handlers;

/**
 *
 * @author Clara Durling
 */
public class Reward {
    private final String date;
    private final String deal;

    public Reward(String date, String deal) {
        this.date = date;
        this.deal = deal;
    }
    
    //**************************************************************************
    
    public String getDate(){
        return this.date;
    }
    
    //**************************************************************************
    
    public String getDeal(){
        return this.deal;
    }
    
    //**************************************************************************

    @Override
    public String toString() {
        return "This member received on " + date + " a " + deal + '.';
    }
    
}