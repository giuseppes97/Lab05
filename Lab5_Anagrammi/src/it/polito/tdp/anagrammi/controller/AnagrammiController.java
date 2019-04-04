package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
  Model modello;
  List<String> listaana=new ArrayList<String>();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField testoparola;

    @FXML
    private Button bottonecalcana;

    @FXML
    private TextArea testoriscorretti;

    @FXML
    private TextArea testoriserrati;

    @FXML
    private Button bottonereset;

    @FXML
    void docalcolaanagrammi(ActionEvent event) {
    	testoriscorretti.clear();
    	testoriserrati.clear();
 String s=testoparola.getText();
listaana= modello.getAnagrammi(s);
for(String a:listaana) {
	testoriscorretti.appendText(a+"\n");
}
listaana.clear();
listaana=modello.getErrati();
for(String a:listaana) {
	testoriserrati.appendText(a+"\n");
}
    }

    @FXML
    void doreset(ActionEvent event) {
testoriscorretti.clear();
testoriserrati.clear();
testoparola.clear();
    }

    @FXML
    void initialize() {
        assert testoparola != null : "fx:id=\"testoparola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bottonecalcana != null : "fx:id=\"bottonecalcana\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert testoriscorretti != null : "fx:id=\"testoriscorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert testoriserrati != null : "fx:id=\"testoriserrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bottonereset != null : "fx:id=\"bottonereset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    public void setModel(Model m) {
    	modello=m;
    }
}
