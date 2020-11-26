let v = new Vue({
   el:'#updatePwd',
   data:function(){
       return{
           user:{},
           content: '发送验证码',
           totalTime: 60,
           canClick: true //添加canClick
       }
   },
   methods:{
       updatePws:function () {
           axios({
               url:'/common/updatePwd',
               method:'post',
               data:this.user
           }).then(response=>{
               if (response.data.obj){
                   alert("修改密码成功");
                   location.href = "/common/login";
               } else {
                   alert(response.data.obj);
               }
           })
       },
       sendCode() {
           axios({
               url:'/common/sendCode',
               params:{
                   "email":this.user.email,
                   "username":this.user.username
               }
           }).then(response=>{
               if (response.data.success){
                   layer.msg(response.data.msg);
               } else {
                   layer.msg(response.data.msg);
               }
           });
           if (!this.canClick) return ; //改动的是这两行代码
           this.canClick = false;
           this.content = this.totalTime + 's后重新发送';
           let clock = window.setInterval(() => {
               this.totalTime--;
               this.content = this.totalTime + 's后重新发送';
               if (this.totalTime < 0) {
                   window.clearInterval(clock);
                   this.content = '重新发送验证码';
                   this.totalTime = 60;
                   this.canClick = true;  //这里重新开启
               }
           },1000)
       }
   }
});