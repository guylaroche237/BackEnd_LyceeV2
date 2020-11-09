package com.sdze.school.metier;

import java.util.List;

import com.sdze.school.entite.Sms;



public interface SmsMetier {
	
	public void addSms(Sms sms);
	public List<Sms> allSms();

}
