import com.u1553617.*;
import com.u1553617.Model.Room;
import com.u1553617.Controller.RoomController;
import com.u1553617.Model.RoomNode;
import com.u1553617.View.Manager;

public class Overall {

    public static void main(String argv[]) {
        Room<RoomNode> roomList = new Room();
        Manager managerView = new Manager();
        RoomController cont = new RoomController(managerView, roomList);

        managerView.showForm();
    }

}
