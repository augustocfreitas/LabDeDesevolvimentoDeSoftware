package sistemaDeMatriculas.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

public class ListarAlunosController {

    @FXML
    private ChoiceBox<?> choiceBox_Curso;

    @FXML
    private ChoiceBox<?> choiceBox_Disciplina;

    @FXML
    private TableView<?> table_ListarAlunos;

    @FXML
    private Button btn_Sair;

    @FXML
    void action_VoltarAreaDoProfessor(ActionEvent event) {

    }

}