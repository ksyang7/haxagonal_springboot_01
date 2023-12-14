package com.professional.yang.application.usecases;

import java.util.Optional;

import com.professional.yang.domain.Member;

public interface FindOneMemberUseCase {

	Optional<Member> findOne(String userId);
}
