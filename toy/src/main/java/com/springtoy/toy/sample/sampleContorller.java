package com.springtoy.toy.sample;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sample")
public class sampleContorller {

    @Autowired
    private sampleDataRepository sampleRepo;

    // controller 경로 테스트
    @GetMapping("test")
    public String test() {
        return "sample/test";
    }

    @GetMapping("success")
    public String success() {
        return "sample/success";
    }

    // ----------------CRUD -----------------
    // 샘플리스트
    @GetMapping("/list")
	public String list(HttpServletRequest request, Model model, @PageableDefault(size = 10) Pageable pageable,
			@RequestParam(required = false, defaultValue = "") String searchText) {

		Page<sampleData> list = sampleRepo.findByTitleContainingOrMemoContainingOrderByIdDesc(searchText, searchText,pageable);

		int startPage = Math.max(1, (list.getPageable().getPageNumber() / pageable.getPageSize()) * pageable.getPageSize()+1 );
		int endPage = Math.min(list.getTotalPages(), startPage + pageable.getPageSize() -1);

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);

		return "sample/sampleList";
	}

}
