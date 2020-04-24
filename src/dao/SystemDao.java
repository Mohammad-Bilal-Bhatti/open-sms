/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Javed Ali Dahri
 */
public interface SystemDao {
    public boolean checkMacAddress(String macAddress);
    public int insertMacAddress(String macAddress);
}
