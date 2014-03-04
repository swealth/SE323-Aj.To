package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.OrderedLogDAO;
import cbsd.lab11.entity.OrderedLog;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderedLogServiceImpl implements OrderedLogService {
    @Autowired
    OrderedLogDAO orderedLogDAO;

    @Override
    @Transactional
    public void addOrderedLog(OrderedLog orderedLog) {
        orderedLogDAO.addOrderedLog(orderedLog);
    }

    @Override
    @Transactional
    public List<OrderedLog> getOrderedLogs() {
        return orderedLogDAO.getOrderedLogs();
    }

    @Override
    @Transactional
    public OrderedLog findById(Long id) {
        return orderedLogDAO.findById(id);
    }

    @Override
    @Transactional
    public List<OrderedLog> searchByUser(String keyword) {
        return orderedLogDAO.searchByUser(keyword);
    }

    @Override
    @Transactional
    public List<OrderedLog> searchByDate(Date date) {
        return orderedLogDAO.searchByDate(date);
    }
}
