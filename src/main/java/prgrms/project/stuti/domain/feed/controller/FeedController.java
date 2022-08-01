package prgrms.project.stuti.domain.feed.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import prgrms.project.stuti.domain.feed.controller.dto.RegisterPostRequest;
import prgrms.project.stuti.domain.feed.service.FeedService;
import prgrms.project.stuti.domain.feed.service.dto.PostCreateDto;
import prgrms.project.stuti.domain.feed.service.dto.PostsResponse;

@RestController
@RequiredArgsConstructor
public class FeedController {

	private final FeedService feedService;

	@PostMapping(path = "/api/v1/posts", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Long> registerPost(@Valid @ModelAttribute RegisterPostRequest registerPostRequest,
		@AuthenticationPrincipal User authentication) {
		Long memberId = Long.parseLong(authentication.getUsername());
		PostCreateDto postCreateDto = FeedMapper.toPostDto(registerPostRequest, memberId);
		Long postId = feedService.registerPost(postCreateDto);

		return ResponseEntity.created(
			URI.create("/api/v1/post/" + postId)
		).body(postId);
	}

	@GetMapping("/api/v1/posts")
	public ResponseEntity<PostsResponse> getAllPosts(@RequestParam(value = "lastPostId", required = false) Long lastPostId,
		@RequestParam(defaultValue = "10") int size) {
		PostsResponse postResponse = feedService.getAllPosts(lastPostId, size);

		return ResponseEntity.ok().body(postResponse);
	}
}
