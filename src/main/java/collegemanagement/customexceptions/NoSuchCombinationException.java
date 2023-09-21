package collegemanagement.customexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoSuchCombinationException extends  RuntimeException{

    private String message;


}
