package com.example.mxhfullstack.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mxhfullstack.model.PageInfo;
import com.example.mxhfullstack.request.CommentSaveRequest;
import com.example.mxhfullstack.request.MessageSaveRequest;
import com.example.mxhfullstack.request.PostSaveRequest;
import com.example.mxhfullstack.response.CommentResponse;
import com.example.mxhfullstack.response.FriendResponse;
import com.example.mxhfullstack.response.ImageResponse;
import com.example.mxhfullstack.response.MessageReponse;
import com.example.mxhfullstack.response.NotificationResponse;
import com.example.mxhfullstack.response.PostResponse;
import com.example.mxhfullstack.response.UserInfoResponse;
import com.example.mxhfullstack.service.CommentService;
import com.example.mxhfullstack.service.FileUpload;
import com.example.mxhfullstack.service.FriendService;
import com.example.mxhfullstack.service.GPTService;
import com.example.mxhfullstack.service.ImageService;
import com.example.mxhfullstack.service.LikeService;
import com.example.mxhfullstack.service.MessageService;
import com.example.mxhfullstack.service.NotificationService;
import com.example.mxhfullstack.service.PostService;
import com.example.mxhfullstack.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fetch")
@AllArgsConstructor
public class FetchApiController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LikeService likeService;
	@Autowired
	private FriendService friendService;
	@Autowired
	private MessageService messageService;
	
    @Autowired
    private GPTService gptService;
    
    @Autowired ImageService imageService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private FileUpload fileUpload;
	
    private final SimpMessagingTemplate template;
    private final SimpUserRegistry userRegistry;
	
	@GetMapping("/username/{username}")
	public UserInfoResponse searchUser(@PathVariable("username") String username, ModelMap model) throws JsonMappingException, JsonProcessingException {
//		UserInfoResponse userInfoResponse = this.userService.userSearch(username);
		model.addAttribute("userInfo", this.userService.userSearch(username));
		System.out.println("user search: " + model);
		return this.userService.userSearch(username);
	
	}
	
	
	@PostMapping("/get/All")
	public List<PostResponse> getAllpost(PageInfo pageInfo) throws JsonMappingException, JsonProcessingException {
		List<PostResponse> posts = postService.getAll(pageInfo);
		return posts;
	}
	
	@PostMapping("/all/me")
	public List<PostResponse> getAllByMe(PageInfo pageInfo, Model model) throws JsonMappingException, JsonProcessingException {
		List<PostResponse> posts = postService.getAllpostByMe(pageInfo);
		model.addAttribute("postsMe", posts);
		return this.postService.getAllpostByMe(pageInfo);
		
	}
	
	@PostMapping("/creat/post")
	public String CreatePost(@RequestBody PostSaveRequest postSaveRequest) throws Exception{
		return postService.createPost(postSaveRequest);
	}
	
	@PostMapping("/cmt/{postId}")
	public List<CommentResponse> getAllcmtByPostId(PageInfo pageInfo, @PathVariable("postId") Long id, Model model) throws JsonMappingException, JsonProcessingException {
		List<CommentResponse> cmts = commentService.getAllcmtByPostId(pageInfo, id);
		model.addAttribute("cmtAll", cmts);
		return cmts;
	}
	
	@PostMapping("/like/{postById}")
	public String like(@PathVariable("postById") Long id, Model model) throws Exception {
		String like = likeService.like(id);
		model.addAttribute("like", like);
		return like;
	}
	
	@PostMapping("/Addcmt/{cmtpostId}")
	public String addcmt(@PathVariable("cmtpostId") Long id, Model model, CommentSaveRequest commentSaveRequest) throws Exception {
		String cmt = commentService.addComment(commentSaveRequest, id);
		model.addAttribute("addcmt",cmt);
		return cmt;
	}
	
	@PostMapping("/delete/{cmtId}")
	public String deleteComment(@PathVariable("cmtId") Long id, Model model) throws Exception {
		String cmt = commentService.deleteComment(id);
		model.addAttribute("addcmt",cmt);
		return cmt;
	}
	
	@PostMapping("/update")
	public String UpdateComment(CommentSaveRequest commentSaveRequest, Model model) throws Exception {
		String cmt = commentService.updateComment(commentSaveRequest);
		model.addAttribute("addcmt",cmt);
		return cmt;
	}
	
	// post user
	
	@PostMapping("/all/{userId}")
	public List<PostResponse> getAllByUserId(PageInfo pageInfo, Model model, @PathVariable("userId") Long id) throws JsonMappingException, JsonProcessingException {
		List<PostResponse> posts = postService.getAllpostByUser(pageInfo, id);
		model.addAttribute("postsMe", posts);
		return this.postService.getAllpostByUser(pageInfo, id);
		
	}
	
	@PostMapping("/message/{userTarget}")
	public String sendMessage(@PathVariable("userTarget") String userTarget, MessageSaveRequest messageSaveRequest, Model model){
		return this.messageService.creatMessage(userTarget, messageSaveRequest);
	}
	
	@PostMapping("/message/alluser")
	public List<MessageReponse> getallUserMessageByme(PageInfo pageInfo, Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("allusermessage", this.messageService.getAlluserMessageByme(pageInfo));
		return this.messageService.getAlluserMessageByme(pageInfo);
	}
	
	@PostMapping("/message/content/{userTarget}")
	public List<MessageReponse> getAllContentMessageByUserTarget(@PathVariable("userTarget") Long userTarget,PageInfo pageInfo, Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("contentMessage", messageService.getAllMessageByMeAndUserId(pageInfo, userTarget));
		return this.messageService.getAllMessageByMeAndUserId(pageInfo, userTarget);
	}
	
	// chat GPT
    @PostMapping("/search")
    public String chatGPT(@RequestBody String query, Model model) {
        String content = gptService.callApi(query);
        return content;
    }
    
    @GetMapping("getAll/image")
    public List<ImageResponse> getAll() throws JsonMappingException, JsonProcessingException {
    	return imageService.getAll();
    }
    
    // notification
    @PostMapping("/getAll/Notification")
    public List<NotificationResponse> getAllNotification(@RequestBody PageInfo pageInfo) throws JsonMappingException, JsonProcessingException {
    	List<NotificationResponse> notificationResponses = notificationService.getAllNotificattion(pageInfo);
    	return notificationResponses;
    }
    
    // edit image
    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("image") MultipartFile multipartFile) throws IOException {
    	String imageUrl = fileUpload.uploadFile(multipartFile);
    	return imageUrl;
    }
	
}
