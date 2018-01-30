package org.aerogear.plugin.intellij.mobile.module;

import org.aerogear.plugin.intellij.mobile.constants.Constants;
import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CreateClientForm extends JPanel {
  private JPanel clientPanel;
  private JTextField clientNameTxtField;
  private JComboBox clientTypeComboBox;
  private JComboBox namespaceComboBox;
  private JLabel clientNameLabel;
  private JLabel clientTypeLabel;
  private JLabel namespaceLabel;
  private JLabel errorLabel;
  private JLabel errorMessage;

  private Border defaultClientNameBorder;

  public CreateClientForm() {
    super();
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    add(clientPanel);
  }

  private void createUIComponents() {
    clientTypeComboBox = new ComboBox(Constants.CLIENT_TYPES);

    //TODO add available namespaces dynamically
    namespaceComboBox = new ComboBox(new String[]{"myproject"});
  }

  /**
   * Returns form as map <name, value>
   *
   * @return map
   */
  public Map getInputs() {
    Map map = new HashMap<String, String>();

    map.put("name", clientNameTxtField.getText());
    map.put("clientType", clientTypeComboBox.getSelectedItem());
    map.put("namespace", namespaceComboBox.getSelectedItem());

    return map;
  }

  /**
   * Set border RED on clientName input to indicate missing/invalid input.
   */
  public void invalidNameNotify() {
    errorLabel.setText("Error");
    errorMessage.setText("Client Name is required");
    defaultClientNameBorder =     clientNameTxtField.getBorder();
    clientNameTxtField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
  }

  /**
   * Set default border on clientName input, to indicate valid input.
   */
  public void validNameNotify() {
    errorLabel.setText("");
    errorMessage.setText("");
    clientNameTxtField.setBorder(defaultClientNameBorder);
  }
}