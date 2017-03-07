/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Media;

/**
 *
 * @author Tech Devil
 */
public class UserNameMedia {
    
    String Id;
   String usrName;

    public UserNameMedia() {
    }

    public UserNameMedia(String Id) {
        this.Id = Id;
    }

    public UserNameMedia(String id, String usrName) {
        this.Id = id;
        this.usrName = usrName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    
}
