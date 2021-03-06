package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class chanceController {
    @FXML private TextField FXMLsuatienganh;
    @FXML private TextField FXMLsuatiengviet;
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public void backDic(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample2.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void chance(ActionEvent event){
        dictionaryManagement.insertFromFile();
        String tu = FXMLsuatienganh.getText();
        tu = tu.trim();
        for(int i=0;i<dictionaryManagement.getDsData().size();i++)
        {
            if(dictionaryManagement.getDsData().get(i).getWord_target().equals(tu)==true )
            {
                dictionaryManagement.getDsData().get(i).setWord_target(FXMLsuatienganh.getText());
                dictionaryManagement.getDsData().get(i).setWord_explain(FXMLsuatiengviet.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Đã sửa!!");
                alert.show();
                break;
            }
            if(i==dictionaryManagement.getDsData().size()-1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Không tìm thấy từ cần sửa!!");
                alert.show();
            }

        }
        dictionaryManagement.Sort();
        dictionaryManagement.SaveToFile();
    }
}
