import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 The view class for representing data in an MVC pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class DataView extends JFrame implements ChangeListener
{
   DataModel dataModel;
   JPanel outPanel;
   JPanel inPanel;

   JTextArea textArea;
   JTextField textField;
   JButton addButton;

   /**
    Constructor method for the DataView class.
    @param d the data to display
    */
   public DataView(DataModel d)
   {
      dataModel = d;

      this.setTitle("Text Box: An MVC Implementation");
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      outPanel = new JPanel();
      outPanel.setPreferredSize(new Dimension(300, 350));
      outPanel.setLayout(new BorderLayout());
      textArea = new JTextArea(dataModel.getText());
      textArea.setEditable(false);
      textArea.setWrapStyleWord(true);
      textArea.setLineWrap(true);
      textArea.setCaretPosition(textArea.getDocument().getLength());
      JScrollPane scrollableTextArea = new JScrollPane(textArea);
      outPanel.add(scrollableTextArea, BorderLayout.CENTER);

      inPanel = new JPanel();
      inPanel.setLayout(new BorderLayout());
      textField = new JTextField();
      addButton = new JButton("Add");
      inPanel.add(textField, BorderLayout.NORTH);
      inPanel.add(addButton, BorderLayout.SOUTH);

      this.getContentPane().add(outPanel, BorderLayout.NORTH);
      this.getContentPane().add(inPanel, BorderLayout.SOUTH);
      this.getRootPane().setDefaultButton(addButton);

      this.pack();
   }

   /**
    Returns the user-defined text from the input field.
    @return input text
    */
   public String getText()
   {
      return textField.getText();
   }

   /**
    Clears the input field.
    */
   public void clearInput()
   {
      textField.setText(null);
   }

   /**
    Attaches an ActionListener to a button.
    @param listenForButton an Action Listener
    */
   public void addButtonListener(ActionListener listenForButton)
   {
      addButton.addActionListener(listenForButton);
   }

   /**
    Sets the focus field.
    */
   public void setFocus()
   {
      textField.requestFocusInWindow();
   }

   /**
    Responds to changes in the model by updating the view.
    @param e a change event.
    */
   @Override
   public void stateChanged(ChangeEvent e)
   {
      textArea.append(dataModel.getText() + "\n");
   }

   /**
    Overloads the setVisible() method by including a default focus.
    @param value
    */
   @Override
   public void setVisible(boolean value)
   {
      super.setVisible(value);
      setFocus();
   }
}
