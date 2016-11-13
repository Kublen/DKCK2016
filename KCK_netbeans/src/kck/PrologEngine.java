/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kck;

import org.jpl7.*;


public class PrologEngine 
{
           
    public String get_solution(String word){
        
    	String t1 = "consult('nazwa.pl')"; 
    	
        Query q1 = new Query(t1);
        
        return t1 + " " + (q1.hasSolution() ? "ok" : "nie ok");
    }

    

}