import { createRouter, createWebHistory } from 'vue-router'
import AuthorizerView from '../views/Authorizer.vue'
import EmployeeView from '../views/Employee.vue'
import HomeView from '../views/Home.vue'
import HrGeneral from '../views/HrGeneral.vue'
import CreateSchoolView from '../views/CreateSchool.vue'
import CreateUserView from '../views/CreateUser.vue'
import EditUserView from '../views/EditUser.vue'
import HrReview from '../views/HrReview.vue'
import logs from '../views/logs.vue'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/Authorizer',
      name: 'authorizer',
      component: AuthorizerView
    },
    {
      path: '/Employee',
      name: 'employee',
      component: EmployeeView
    },
    {
      path: '/HrGeneral',
      name: 'hr',
      component: HrGeneral
    },
    {
      path: '/createschool',
      name: 'createschool',
      component: CreateSchoolView
    },
    {
      path: '/createuser',
      name: 'createuser',
      component: CreateUserView
    },
    {
      path: '/edituser',
      name: 'edituser',
      component: EditUserView
    },
    {
      path: '/HrReview',
      name: 'HrReview',
      component: HrReview,
      props: true
    },
    {
      path: '/logs',
      name: 'logs',
      component: logs,
    },
  ]
})

export default router
