package cbsd.lab11.service;

import cbsd.lab11.entity.OrderedLog;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderedLogService {
    public void addOrderedLog(OrderedLog orderedLog);
    public List<OrderedLog> getOrderedLogs();
    public OrderedLog findById(Long id);
    public List<OrderedLog> searchByUser(String keyword);
    public List<OrderedLog> searchByDate(Date date);
}
