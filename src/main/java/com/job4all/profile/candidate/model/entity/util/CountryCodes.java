package com.job4all.profile.candidate.model.entity.util;

public enum CountryCodes {
    USA("USA");
	private String countryCode;
    private CountryCodes(String countryCode) {
    	this.countryCode=countryCode;
    }
    public String code() {
        return countryCode;
    }
}