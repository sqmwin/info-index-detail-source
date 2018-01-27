package com.mindnode.immipal.controller;

import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.pojo.Ad;
import com.mindnode.immipal.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/27
 */
@Controller
@RequestMapping("/admin")
public class AdController {
    @Autowired
    AdService adService;

    /**
     * 显示全部广告列表
     * 广告管理页面
     */
    @RequestMapping(value = "/admin_ad_list", method = RequestMethod.GET)
    public String listAd(Model model) {
        List<Ad> adList = null;
        try {
            adList = adService.listAll();
        } catch (NullListException e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("adList", adList);
        return "admin/listAd";
    }
}
