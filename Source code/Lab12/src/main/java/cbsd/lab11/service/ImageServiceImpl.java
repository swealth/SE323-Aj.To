package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.ImageDAO;
import cbsd.lab11.entity.Image;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImageDAO imageDAO;

    @Override
    @Transactional
    public Image get(Long id) {
        return imageDAO.get(id);
    }
}
