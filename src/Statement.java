import java.time.LocalDateTime;
import java.util.Collections;

class Statement {

    private LocalDateTime time;
    private Integer id;
    private float previous;
    private float change;
    private float current;

    public void setTime() {
        if (time == null ){
            time = LocalDateTime.now();
        }
    }


    public Statement(Integer ID, float Previous,float Change,float Current) {
        id = ID;
        previous = Previous;
        change = Change;
        current = Current;
    }
}