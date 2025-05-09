import { Component, OnInit } from '@angular/core';

import { PostsService } from '../../services/posts.service';
import { Posts } from '../../models/posts';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-posts-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './posts-list.component.html',
  styleUrl: './posts-list.component.scss'
})




export class PostsListComponent implements OnInit {
  posts: Posts[] = [];
  groupPosts:{ [key: number]: any[] } = {};
  constructor(private postsService: PostsService) { }

  ngOnInit(): void {
    this.postsService.getPosts().subscribe((data: Posts[]) => {
      this.posts = data;
      this.groupPostsByUser();
    });
  }

  groupPostsByUser(): void {
    this.groupPosts = this.posts.reduce((acc, post) => {
      if (!acc[post.userId]) {
        acc[post.userId] = [];
      }
      acc[post.userId].push(post);
      return acc;
    }, {} as { [key: number]: any[] });
  }

}
