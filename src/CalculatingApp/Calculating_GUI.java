/*
Class Name:  Calculating_GUI 
Class Author:  Mary Waite
******************************************************
Purpose of the class: Provide the GUI for the calculator
******************************************************
Date: 30 August 2017
******************************************************
List of changes with dates: 
12 September 2017 - Add CalcList() to call from different events
20 September 2017 - Add NewList button
20 September 2017 - Add StartOver() to reset program at user request
******************************************************
Look at this!
- added visual ease-of-use by activating and deactivating the calculate button when necessary.
- Used the setVisible() function on the mean and standard deviation for user-simplification. 

*/
package CalculatingApp;

import java.awt.event.KeyEvent;

/**
 *
 * @author mw047
 */
public class Calculating_GUI extends javax.swing.JFrame {

    int SIZE = 10;          //size of array for user to enter
    Calculations calc = new Calculations(SIZE); //create new array in Calculations object
    int index = 0;          //start count for user numbers input
    String showNums = "";   //display variable for numbers entered
    //boolean newList = true;
    /**
     * Creates new form Calculating_GUI
     */
    public Calculating_GUI() {
        initComponents();
        MeanLabel.setVisible(false);    //hide until mean is calculated
        StdLabel.setVisible(false);     //hide until Standard Deviation is calculated
        //Input.setFocusTraversalKeysEnabled(true);
    }
    
    /*******************************************************
    * Method Name: CalcList()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: contains commands to call calculations
    * Method Inputs: none
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    private void CalcList()
    {
        double in = 0;
        jLabel2.setText("");
        try{
            in = Double.parseDouble(Input.getText());
            
                    //display numbers entered thus far
        showNums += "\t" + Input.getText();
        UserList.setText(showNums);
        
        //clear input box
        Input.setText("");
                
        //pass index number and value to calc array
        calc.AddCalculations(index, in);
        
        //stop entry after 10 entered
        if(index<(SIZE-1))
        {
            index++;  
            
            //Change text on button to indicate last number being entered
            if(index == (SIZE-1))
                Calculate.setText("Calculate");
        }   
        else
        {
            MeanLabel.setVisible(true);             //Show MeanLabel
            StdLabel.setVisible(true);              //Show Standard Deviation Label
            MeanResult.setText(Double.toString(calc.getMean()));    //Display Mean
            StdResult.setText(Double.toString(calc.getStd()));      //Display Standard Deviation
            Calculate.setEnabled(false);            //Disable Calculate button to prevent excess numbers from being entered
            //Calculate.setText("Start New List");
        } 
        }
        catch(Exception ex)
        {
            jLabel2.setText("Could not convert input to a double");
            Input.selectAll();
            Input.requestFocus();
        }
        

        
        
     
    }
    
    /*******************************************************
    * Method Name: StartOver()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: Clear all fields & create new array for new calculations
    * Method Inputs: none
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    private void StartOver()
    {
            calc = new Calculations(SIZE);      //create new object & array within object
            index = 0;              //reset index to start new count
            showNums = "";              //clear text area field
            Calculate.setEnabled(true);     //enable calculate button for new array
            Calculate.setText("Add to Calculations");       //reset tex to start new array
            MeanLabel.setVisible(false);    //hide mean label until calculated
            MeanResult.setText("");         //clear mean results
            StdLabel.setVisible(false);     //hide standard deviation label until calculated
            StdResult.setText("");          //clear standard deviation results
            UserList.setText("");           //clear UserList
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Input = new javax.swing.JTextField();
        Calculate = new javax.swing.JButton();
        StdLabel = new javax.swing.JLabel();
        MeanLabel = new javax.swing.JLabel();
        StdResult = new javax.swing.JLabel();
        MeanResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserList = new javax.swing.JTextArea();
        NewList = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);

        Title.setBackground(java.awt.Color.lightGray);
        Title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Calculations of Means & Standard Deviations");

        Input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Input.setMaximumSize(new java.awt.Dimension(60, 90));
        Input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InputKeyPressed(evt);
            }
        });

        Calculate.setLabel("Add to Calculations");
        Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateActionPerformed(evt);
            }
        });
        Calculate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CalculateKeyPressed(evt);
            }
        });

        StdLabel.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        StdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StdLabel.setText("Standard Deviation");

        MeanLabel.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        MeanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MeanLabel.setText("Mean");

        StdResult.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        StdResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        MeanResult.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        MeanResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        UserList.setColumns(20);
        UserList.setLineWrap(true);
        UserList.setRows(5);
        jScrollPane1.setViewportView(UserList);

        NewList.setText("Start New List");
        NewList.setToolTipText("");
        NewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewListActionPerformed(evt);
            }
        });
        NewList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NewListKeyPressed(evt);
            }
        });

        jLabel2.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Calculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewList, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MeanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MeanResult, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StdResult, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Calculate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(Input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MeanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MeanResult, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(StdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StdResult, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter 10 numbers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*******************************************************
    * Method Name: CalculateActionPerformed()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: call CalcList() on button press
    * Method Inputs: ActionEvent evt
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    private void CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateActionPerformed
        CalcList();
    }//GEN-LAST:event_CalculateActionPerformed

    /*******************************************************
    * Method Name: InputKeyPressed()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: Call CalcList() on Enter-Button-press
    * Method Inputs: KeyEvent evt
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    private void InputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            CalcList();
    }//GEN-LAST:event_InputKeyPressed

    /*******************************************************
    * Method Name: CalculateKeyPressed()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: Call CalcList() on Enter-button-press
    * Method Inputs: KeyEvent evt
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    private void CalculateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CalculateKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            CalcList();
    }//GEN-LAST:event_CalculateKeyPressed

    /*******************************************************
    * Method Name: NewListKeyPressed()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: Call StartOver() on Enter-Button-Press
    * Method Inputs: KeyEvent evt
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 20 September 2017
    *******************************************************/
    private void NewListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewListKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            StartOver();
        }
    }//GEN-LAST:event_NewListKeyPressed

    /*******************************************************
    * Method Name: NewListActionPerformed
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: call StartOver() method on mouse click
    * Method Inputs: ActionEvent evt
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 20 September 2017
    *******************************************************/
    private void NewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewListActionPerformed
        StartOver();
    }//GEN-LAST:event_NewListActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculating_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculating_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculating_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculating_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculating_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calculate;
    private javax.swing.JTextField Input;
    private javax.swing.JLabel MeanLabel;
    private javax.swing.JLabel MeanResult;
    private javax.swing.JButton NewList;
    private javax.swing.JLabel StdLabel;
    private javax.swing.JLabel StdResult;
    private javax.swing.JLabel Title;
    private javax.swing.JTextArea UserList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
