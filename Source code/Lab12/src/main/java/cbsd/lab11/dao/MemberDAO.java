package cbsd.lab11.dao;

import cbsd.lab11.entity.Member;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 12:29 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MemberDAO {
    public void addMember(Member member);
    public void deleteMember(Member member);
    public List<Member> getMembers();
    public Member findByUsername(String username);
    public List<Member> searchMember(String keyword);
}
