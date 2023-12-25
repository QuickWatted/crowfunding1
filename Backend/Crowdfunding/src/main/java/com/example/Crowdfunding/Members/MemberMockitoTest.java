package com.example.Crowdfunding.Members;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class MemberMockitoTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMembers() {
        // Given
        Member member1 = new Member(/* construire un objet Member avec des valeurs */);
        Member member2 = new Member(/* construire un objet Member avec des valeurs */);
        List<Member> members = Arrays.asList(member1, member2);

        when(memberRepository.findAll()).thenReturn(members);

        // When
        List<Member> result = memberService.getAllMembers();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    void testGetMemberById() {
        // Given
        Long memberId = 1L;
        Member member = new Member(/* construire un objet Member avec des valeurs */);

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        // When
        Optional<Member> result = memberService.getMemberById(memberId);

        // Then
        assertNotNull(result);
    }

    @Test
    void testCreateMember() {
        // Given
        Member member = new Member(/* construire un objet Member avec des valeurs */);

        // When
        memberService.createMember(member);

        // Then
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    void testUpdateMember() {
        // Given
        Long memberId = 1L;
        Member existingMember = new Member(/* construire un objet Member existant avec des valeurs */);
        Member updatedMember = new Member(/* construire un objet Member mis à jour avec des valeurs */);

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(existingMember));

        // When
        memberService.updateMember(memberId, updatedMember);

        // Then
        verify(memberRepository, times(1)).findById(memberId);
        verify(memberRepository, times(1)).save(existingMember);
    }

    @Test
    void testDeleteMember() {
        // Given
        Long memberId = 1L;

        // When
        memberService.deleteMember(memberId);

        // Then
        verify(memberRepository, times(1)).deleteById(memberId);
    }
}
