/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import beans.BridgeBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface BridgeDao {
    public ResultSet getAllRecords();
    public int addBridge(BridgeBean bridge);
    public int updateBridge(BridgeBean bridge);
    public int deleteBridge(BridgeBean bridge);
    public BridgeBean getBridgeById(Integer btId);    
}
