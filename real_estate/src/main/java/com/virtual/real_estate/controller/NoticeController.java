package com.virtual.real_estate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {

	@RequestMapping("/notice/faq")
    public String faq() {
        return "real_estate/notice_list/faq_list"; 
    }
	
	@RequestMapping("/notice/qna")
    public String qna() {
        return "real_estate/notice_list/qna_list"; 
    }
	
	@RequestMapping("/notice/nontification")
    public String nontification() {
        return "real_estate/notice_list/nontification_list"; 
    }
	
	@RequestMapping("/notice/faq/faq_sub")
    public String faqSub() {
        return "real_estate/notice_list/faq_sub_list"; 
    }
	
	@RequestMapping("/notice/nontification/nontification_sub")
    public String nontificationSub() {
        return "real_estate/notice_list/nontification_sub_list"; 
    }
}
