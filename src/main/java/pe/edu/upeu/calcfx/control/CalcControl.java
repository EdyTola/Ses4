package pe.edu.upeu.calcfx.control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class CalcControl {

    @FXML
    TextField txtResultado;

    @FXML
    public void acccionButton(ActionEvent event){
        Button button=(Button) event.getSource();
        switch (button.getId()){
            case "btn7","btn8","btn9","btn6","btn5","btn4","btn3","btn2","btn1","btn0":{
                escribirNumeros(button.getText());
            }break;
            case "btnSum", "btnMul","btnRes","btnDiv":{
                operador(button.getText());
            }break;
            case "btnIgual":{
                calculcarResultado();
            }break;
            case "btnBorrar":{
                txtResultado.clear();
            }

        }

    }

    public void escribirNumeros(String valor){
        txtResultado.appendText(valor);
    }

    public void operador(String valor){
        txtResultado.appendText(" "+valor+" ");
    }

    public void calculcarResultado(){
        String[] valores=txtResultado.getText().split("");
        double val1=Double.parseDouble(String.valueOf(valores[0]));
        double val2=Double.parseDouble(String.valueOf(valores[2]));


        switch (valores[1]){
            case "+":{txtResultado.setText(String.valueOf(val1+val2));}
            case "-":{txtResultado.setText(String.valueOf(val1-val2));}
            case "/":{txtResultado.setText(String.valueOf(val1/val2));}
            case "*":{txtResultado.setText(String.valueOf(val1*val2));}


        System.out.println(valores[0]);
        System.out.println(valores[1]);
        System.out.println(valores[2]);
    }

}
}
