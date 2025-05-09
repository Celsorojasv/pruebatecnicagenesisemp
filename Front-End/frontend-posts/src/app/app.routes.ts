import { Routes } from '@angular/router';
import { PostsListComponent } from './posts/posts-list/posts-list.component';
export const routes: Routes = [
    {path: 'posts', component: PostsListComponent, pathMatch: 'full'},
];
