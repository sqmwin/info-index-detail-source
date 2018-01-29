package com.mindnode.immipal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mindnode.immipal.exception.list.NullListException;
import com.mindnode.immipal.exception.object.NullObjectException;
import com.mindnode.immipal.pojo.Ad;
import com.mindnode.immipal.service.AdService;
import com.mindnode.immipal.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    public String listAd(Integer pageNum, Model model) {
        final int pageSize = 10;
        if (pageNum == null) {
            PageHelper.startPage(1, pageSize);
        } else {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<Ad> adList = null;
        try {
            adList = adService.listAll();
        } catch (NullListException e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("adList", adList);


        PageInfo<Ad> pageInfo = new PageInfo<>(adList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listAd";
    }

    /**
     * 新增广告
     */
    @RequestMapping(value = "/admin_ad_add", method = RequestMethod.POST)
    public String addAd(HttpSession session, Ad ad, MultipartFile file, Model model) {
        if (ad.getAdTitle() == null && ad.getAdLink() == null) {
            model.addAttribute("message", "广告标题或广告链接不能为空");
            return "redirect:/admin/admin_ad_list";
        } else {
            final long now = System.currentTimeMillis();
            final Date nowDate = new Date(now);
            ad.setAdCreateTime(now);
            ad.setAdDate(nowDate);
            try {
                String picPath = FileUpLoad.uploadPic(session, file);
                ad.setAdImgUrl(picPath);
            } catch (Exception e) {
                model.addAttribute("message", e.getMessage());
            }
        }
        adService.add(ad);
        return "redirect:/admin/admin_ad_list";
    }

    /**
     * 编辑广告的页面
     */
    @RequestMapping(value = "/admin_ad_edit_page", method = RequestMethod.GET)
    public String editAdPage(Integer adId, Model model) {
        Ad ad = null;
        try {
            ad = adService.get(adId);
        } catch (NullObjectException e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("ad", ad);
        return "/admin/edit/editAd";
    }
    /**
     * 编辑广告
     */
    @RequestMapping(value = "/admin_ad_edit", method = RequestMethod.POST)
    public String editAd(HttpSession session, Ad ad, MultipartFile file, String changeImg, Model model) {
        try {
            Ad originalAd = adService.get(ad.getAdId());
            ad.setAdCreateTime(originalAd.getAdCreateTime());
            ad.setAdDate(originalAd.getAdDate());
            final String yes = "yes";
            final String no = "no";
            if (changeImg.equals(yes)) {
                String picPath = FileUpLoad.uploadPic(session, file);
                ad.setAdImgUrl(picPath);
            } else if (changeImg.equals(no)) {
                ad.setAdImgUrl(originalAd.getAdImgUrl());
            }
            adService.update(ad);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "redirect:/admin/admin_ad_list";
    }
    /**
     * 删除广告
     */
    @RequestMapping(value = "/admin_ad_delete", method = RequestMethod.GET)
    public String deleteAd(Integer adId) {
        adService.delete(adId);
        return "redirect:/admin/admin_ad_list";
    }
}

