package cbsd.lab11.service;

import cbsd.lab11.entity.Member;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MemberService {
    public void addMember(Member member);
    public void deleteMember(Member member);
    public List<Member> getMembers();
    public Member findById(String username);
    public List<Member> searchMember(String keyword);
}
