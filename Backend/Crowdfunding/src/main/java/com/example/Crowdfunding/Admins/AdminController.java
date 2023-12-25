package com.example.Crowdfunding.Admins;



import com.example.Crowdfunding.Categories.Categories;
import com.example.Crowdfunding.Categories.CategoriesService;
import com.example.Crowdfunding.Comments.Comment;
import com.example.Crowdfunding.Comments.CommentService;
import com.example.Crowdfunding.LoginDTO;
import com.example.Crowdfunding.Members.Member;
import com.example.Crowdfunding.Members.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admins")
public class AdminController {

    private final AdminService adminService;
    private final CategoriesService categoriesService;
    private final CommentService commentService;
    private final MemberRepository memberRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminController(AdminService adminService, CategoriesService categoriesService, CommentService commentService, MemberRepository memberRepository) {
        this.adminService = adminService;
        this.categoriesService = categoriesService;
        this.commentService = commentService;
        this.memberRepository = memberRepository;
    }


    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
    @PutMapping("/{id}")
    public void updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        adminService.updateAdmin(id, admin);
    }
    //Login
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginAdmin(@RequestBody LoginDTO loginDTO) {
        logger.info("Received login request for email: {}", loginDTO.getEmail());

        // Your existing login logic here
        boolean loginSuccess = adminService.authenticateAdmin(loginDTO.getEmail(), loginDTO.getPassword());

        if (loginSuccess) {
            logger.info("Login successful for email: {}", loginDTO.getEmail());

            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("message", "Login successful");
            // ... other success details ...

            return ResponseEntity.ok(successResponse);
        } else {
            logger.warn("Login failed for email: {}", loginDTO.getEmail());

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized access");
            // ... other error details ...

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }



    //manage categories
    @PostMapping("/categories")
    public void createCategory(@RequestBody Categories category) {
        categoriesService.createCategory(category);
    }
    @GetMapping("/categories")
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }
    @GetMapping("/categories/{id}")
    public Optional<Categories> getCategoryById(@PathVariable Long id) {
        return categoriesService.getCategoryById(id);
    }
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategory(id);
    }

//manage member
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
//manage comment
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
