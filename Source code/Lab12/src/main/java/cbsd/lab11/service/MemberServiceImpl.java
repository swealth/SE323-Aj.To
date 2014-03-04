package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.MemberDAO;
import cbsd.lab11.entity.Member;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDAO memberDAO;

    @Override
    @Transactional
    public void addMember(Member member) {
        memberDAO.addMember(member);
    }

    @Override
    @Transactional
    public void deleteMember(Member member) {
        memberDAO.deleteMember(member);
    }

    @Override
    @Transactional
    public List<Member> getMembers() {
        return memberDAO.getMembers();
    }

    @Override
    @Transactional
    public Member findById(String username) {
        return memberDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public List<Member> searchMember(String keyword) {
        return memberDAO.searchMember(keyword);
    }
}
