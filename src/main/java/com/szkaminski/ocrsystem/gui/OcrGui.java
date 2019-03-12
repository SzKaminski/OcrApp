package com.szkaminski.ocrsystem.gui;

import com.szkaminski.ocrsystem.service.OcrService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.io.File;
import java.io.IOException;

@Route
public class OcrGui extends VerticalLayout {

    private TextField textFieldUserUrl;
    private ComboBox comboBoxLang;
    private Button button;
    private TextArea textFromUrl;

    private String ocrDone;

    public OcrGui(){
        ApiLanguage.fillThelist();
        guiInit();
    }

    public void guiInit(){
        textFieldUserUrl = new TextField("Type url");
        comboBoxLang = new ComboBox("Choose language of text");
        button = new Button("Submit");
        textFromUrl = new TextArea("Just Copy All from Here :)");

        comboBoxLang.setItems(ApiLanguage.getLangList());
        comboBoxLang.addValueChangeListener(e -> {
            File langValue = (File)comboBoxLang.getValue();
            ApiLanguage.setLanguage(langValue.toString());
        });
        button.addClickListener(ce -> {
            try {
                setText();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        textFromUrl.setReadOnly(true);
        add(textFieldUserUrl);
        add(comboBoxLang);
        add(button);
        add(textFromUrl);
    }

    public void setText() throws IOException {
        ocrDone = OcrService.doOCR(textFieldUserUrl.getValue());
        textFromUrl.setValue(ocrDone);
    }
}
