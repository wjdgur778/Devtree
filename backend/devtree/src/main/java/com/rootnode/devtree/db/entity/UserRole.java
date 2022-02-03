package com.rootnode.devtree.db.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    GUEST("ROLE_MENTOR", "멘토"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
