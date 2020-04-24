/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import beans.BatchBean;

/**
 *
 * @author Bilal Bhatti
 */
public interface BatchDao {
    public List<BatchBean> getAllBatches();
    public int addBatch(BatchBean batch);
    public int updateBatch(BatchBean batch);
    public int deleteBatch(BatchBean batch);
    public BatchBean getBatchById(Integer batchId);
}
