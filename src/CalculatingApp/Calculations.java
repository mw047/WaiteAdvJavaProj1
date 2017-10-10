/*
Class Name: Calculations  
Class Author: Mary Waite
******************************************************
Purpose of the class: Performs Calculations & stores variables

******************************************************
Date: 30 August 2017
******************************************************
List of changes with dates. 
******************************************************


*/
package CalculatingApp;

/**
 *
 * @author mw047
 */
public class Calculations {
    private double[] userNums;
    double mean, stD;

      
    /*******************************************************
    * Method Name: Calculations
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: constructor
    * Method Inputs: none
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 30 August 2017
     * @param SIZE
    *******************************************************/
    Calculations(int SIZE)
    {
        userNums = new double[SIZE];
    }
    
    /*******************************************************
    * Method Name: AddCalculations
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: add input to array
    * Method Inputs: index, number input
    * Return value: none
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    public void AddCalculations(int i, double num)
    {
        userNums[i] = num;
    }
    
    /*******************************************************
    * Method Name: getMean()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: return mean 
    * Method Inputs: none
    * Return value: mean
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    public double getMean()
    {
        double sum = 0;
        double m = 0;
        
        for(int i = 0; i < userNums.length; i++)
        {
            sum += userNums[i];
        }
        
        m = sum/userNums.length;
        
        return m;
       
    }
    
    /*******************************************************
    * Method Name: getStd()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: return Standard Deviation 
    * Method Inputs: none
    * Return value: stD
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    public double getStd()
    {
        
        double sd = 0;                  //standard deviation
        for(int i = 0; i < userNums.length; i++)     //cycle through array
        {
            sd += Math.pow((userNums[i]-getMean()), 2) / userNums.length ;          
        }
        
        sd = Math.sqrt(sd);
        //System.out.println(sd);
        
        return sd;
    }
    
    /*******************************************************
    * Method Name: getUserNums()
    * Method Author: Mary Waite
    ****************************************************** 
    * Purpose of the Method: return user-entered number array
    * Method Inputs: none
    * Return value: userNums array
    ******************************************************
    * List of changes with dates:
    ******************************************************
    * Date: 12 September 2017
    *******************************************************/
    public double[] getUserNums()
    {
        return userNums;
    }
    
        

    
}
