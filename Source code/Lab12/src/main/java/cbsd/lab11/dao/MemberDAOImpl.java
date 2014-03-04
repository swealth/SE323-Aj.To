package cbsd.lab11.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import cbsd.lab11.entity.Member;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Md5PasswordEncoder encoder;

    @Override
    public void addMember(Member member) {
        member.setPassword(encoder.encodePassword(member.getPassword(),null));
        sessionFactory.getCurrentSession().saveOrUpdate(member);
    }

    @Override
    public void deleteMember(Member member) {
        sessionFactory.getCurrentSession().delete(member);
    }

    @Override
    public List<Member> getMembers() {
        return sessionFactory.getCurrentSession().createQuery("from Member").list();
    }

    @Override
    public Member findByUsername(String username) {
        Member member = (Member) sessionFactory.getCurrentSession().createQuery
                ("from Member m where m.username ='" + username + "'").uniqueResult();
        return member;
    }

    @Override
    public List<Member> searchMember(String keyword) {
        Set<Member> expected = new HashSet<Member>();
        List result = sessionFactory.getCurrentSession().createQuery("from Member m where lower(m.username) like '%"+ keyword.toLowerCase() +"%'").list();
        expected.addAll(result);
        result = sessionFactory.getCurrentSession().createQuery("from Member m where lower(m.name) like '%"+ keyword.toLowerCase() +"%'").list();
        expected.addAll(result);
        return new ArrayList<Member>(expected);
    }
}
