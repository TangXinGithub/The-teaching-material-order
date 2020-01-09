<template>
<div class="layout">
    <Layout>
    <Sider hide-trigger>Sider</Sider>
    <Layout>
      <Header>Header</Header>
      <Content>Content
      <book-form-teacher></book-form-teacher>
      </Content>
      <Footer>Footer</Footer>
    </Layout>
  </Layout>
</div>
</template>
<script>
  import bookFormTeacher from "../bookForm/bookFormTeacher";
    export default {
        name: "teacher",
      components: {bookFormTeacher},

    }
</script>

<style scoped>

</style>
