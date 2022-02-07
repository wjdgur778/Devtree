package com.rootnode.devtree.api.service;

import com.rootnode.devtree.api.request.UserRegisterPostReq;
import com.rootnode.devtree.api.request.UserUpdateRequestDto;
import com.rootnode.devtree.api.response.UserDetailResponseDto;
import com.rootnode.devtree.db.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */

public interface UserService {
	User createUser(UserRegisterPostReq userRegisterInfo);
	User getUserByUserId(String userId);
	List<User> getUsers();
	public void UpdateUser(Long userSeq, UserUpdateRequestDto userUpdateRequestDto);
	public UserDetailResponseDto getUserDetailByUserId(String userId);
}